public static String organizingContainers(List<List<Integer>> container) {
        int j=0;
        for(int i=0;i<container.size();i++){
            long columnSum=0;
            for(int k=0;k<container.size();k++){
                if(k!=i){
                    columnSum=columnSum+container.get(k).get(j);
                }
            }
            System.out.println(j+"th column Sum : "+columnSum);
            long rowSum=0;
            for(int k=0;k<container.get(i).size();k++){
                if(k!=j){
                    rowSum=rowSum+container.get(i).get(k);
                }
            }
            System.out.println(i+"th row Sum : "+rowSum);
            if(rowSum!=columnSum){
                return "Impossible";
            }
            j++;
        }
        return "Possible";
    }