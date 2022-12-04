class Pair{
    int dest;
    int cost;
    public Pair(int dest,int cost){
        this.dest = dest;
        this.cost = cost;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        
       int m = roads.length;
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        
        boolean visited[] = new boolean[n+1];
        Queue<Pair> que = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        que.offer(new Pair(1,Integer.MAX_VALUE));
        
        while (!que.isEmpty()){
            int dest = que.peek().dest;
            int cost = que.peek().cost;
            que.poll();
            min = Math.min(min,cost);
            if (!visited[dest]){
                
                for (int i=0;i<adj.get(dest).size();i++){
                    int a = adj.get(dest).get(i).dest;
                    int b = adj.get(dest).get(i).cost;
                    que.offer(new Pair(a,b));
                }                
                
            }
            visited[dest] = true;
        }
        return min;
    }
}