## DfsBinaryGroupFinder: 
### findConnectedGroups:
- This method is similar to the forest-fire implementation we did except using dfs instead of bfs.
- Returns a list of groups, a group is a record of the size of the cluster and the center coordinate of the cluster
- for this method we will need a visited set.
- we will need to loop over the whole graph and do a dfs on ever coordinate with 1 if its not in the visited set.
- Once we do dfs, we will need to create the Group record by finding the center coordinate of the cluster and find the size of the cluster, then add that to our result list. 