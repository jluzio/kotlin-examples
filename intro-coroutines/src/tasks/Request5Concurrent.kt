package tasks

import contributors.*
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun loadContributorsConcurrent(service: GitHubService, req: RequestData): List<User> =
  coroutineScope {
    val repos = async {
      service
        .getOrgRepos(req.org)
        .also { logRepos(req, it) }
        .body() ?: emptyList()
    }.await()

    repos.map { repo ->
      async {
        log("starting loading for ${repo.name}")
        delay(3000)
        // load repo contributors
        service
          .getRepoContributors(req.org, repo.name)
          .also { logUsers(repo, it) }
          .bodyList()
      }
    }
      .awaitAll()
      .flatten()
      .aggregate()
  }