class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numeros = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1]; // lista com bucket para colocar os numeros nos indices de sua frequencia

        for (int i = 0 ; i < nums.length ; i++ ){
            int num = nums[i];

            if (numeros.containsKey(num)){
                int contagemAtual = numeros.get(num);
                numeros.put(num, contagemAtual + 1); // coloco como key o numero e como valor a sua frequencia
            }
            else{
                numeros.put(num, 1);
            }
        }

        for (int chave : numeros.keySet()){
            int frequencia = numeros.get(chave); // pego a frequencia para colocar no indice do bucket
            if (buckets[frequencia] == null) { 
                buckets[frequencia] = new ArrayList<>();
            }
    
            buckets[frequencia].add(chave);
            
        }

        int[] resultado = new int[k];
        int indexResultado = 0;

        for (int i = buckets.length - 1 ; i >= 0 ; i-- ){
            // for comecando do final para achar o mais frequente
            if(buckets[i] != null ){
                for (int num : buckets[i]){
                    resultado[indexResultado] = num;
                    indexResultado++;
                    
                    if (indexResultado == k) { // condicao de parada 
                        return resultado;
                    }
                }
            }
        }
        
        return resultado;

    }
}
