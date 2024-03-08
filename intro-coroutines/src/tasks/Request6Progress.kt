package tasks

import contributors.*

suspend fun loadContributorsProgress(
  service: GitHubService,
  req: RequestData,
  updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
  val repos = service
    .getOrgRepos(req.org)
    .also { logRepos(req, it) }
    .body() ?: emptyList()

  var allUsers = emptyList<User>()
  repos.forEachIndexed { i, repo ->
    val users = service
      .getRepoContributors(req.org, repo.name)
      .also { logUsers(repo, it) }
      .bodyList()
    allUsers = (allUsers + users).aggregate()
    updateResults(allUsers, i == repos.size - 1)
  }
}
