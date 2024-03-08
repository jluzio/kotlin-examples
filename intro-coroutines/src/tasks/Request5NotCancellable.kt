package tasks

import contributors.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay

suspend fun loadContributorsNotCancellable(service: GitHubService, req: RequestData): List<User> {
  val repos = GlobalScope.async {
    service
      .getOrgRepos(req.org)
      .also { logRepos(req, it) }
      .body() ?: emptyList()
  }.await()

  return repos.map { repo ->
    GlobalScope.async {
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