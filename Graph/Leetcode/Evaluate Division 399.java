class Solution {
    static double[] res;
    static int index;
    static boolean flag;
    public static void DFS(Map<String,List<Pair<String,Double>>> map,String curr,String des,Set<String> visited,double ans){
        visited.add(curr);
        if(curr.equals(des)){
            flag = true;
            res[index++] = ans;
            return;
        }
        for(Pair<String,Double> p:map.get(curr)){
            String adj = p.getKey();
            double w = p.getValue();
            if(!visited.contains(adj)){
                DFS(map,adj,des,visited,ans*w);
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> map = new HashMap<>();
        index=0;
        for(List<String> list:equations){
            String u = list.get(0);
            String v = list.get(1);
            double w = values[index++];
            if(!map.containsKey(u)){
                map.put(u,new ArrayList<>());
            }
            if(!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(u).add(new Pair<>(v,w));
            map.get(v).add(new Pair<>(u,1/w));
        }
        index = 0;
        res = new double[queries.size()];
        for(List<String> q:queries){
            String src = q.get(0);
            String des = q.get(1);
            if(!map.containsKey(src) || !map.containsKey(des)){
                res[index++] = -1.0;
            }else{
                flag = false;
                DFS(map,src,des,new HashSet<>(),1);
                if(!flag) res[index++] = -1.0;
            }
        }
        return res;
    }
}
