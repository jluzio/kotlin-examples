package tasks

import contributors.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

suspend fun loadContributorsChannels(
  service: GitHubService,
  req: RequestData,
  updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
  coroutineScope {
    val repos = async {
      service
        .getOrgRepos(req.org)
        .also { logRepos(req, it) }
        .body() ?: emptyList()
    }.await()

    val usersChannel = Channel<List<User>>()
    repos.forEach() { repo ->
      launch {
        log("starting loading for ${repo.name}")
//        delay(3000)
        // load repo contributors
        val users = service
          .getRepoContributors(req.org, repo.name)
          .also { logUsers(repo, it) }
          .bodyList()
        usersChannel.send(users)
      }
    }

    launch {
      var allUsers = emptyList<User>()
      repeat(repos.size) {
        val users = usersChannel.receive()
        allUsers = (allUsers + users).aggregate()
        updateResults(allUsers, it == repos.size - 1)
      }
    }
  }
}
