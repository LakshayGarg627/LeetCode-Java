class Solution {
    public void indegree(ArrayList<ArrayList<Integer>> graph,int indeg[]){
        for(int i=0;i<graph.size();i++){
            int v=i;
            for(int j=0;j<graph.get(v).size();j++){
                int neigh=graph.get(v).get(j);

                indeg[neigh]++;
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            graph.get(v).add(u);
        }

        int indeg[]=new int[numCourses];
        indegree(graph,indeg);

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            temp.add(curr);
            for(int i=0;i<graph.get(curr).size();i++){
                int neigh=graph.get(curr).get(i);
                indeg[neigh]--;
                if(indeg[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        return temp.size()==numCourses;

    }
}