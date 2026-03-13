class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, Integer> anagramas = new HashMap<>();
        List<List<String>> resultado = new ArrayList<>();

        for (int i = 0; i < strs.length ; i++ ){
            char[] stringOrdenada = strs[i].toCharArray();
            Arrays.sort(stringOrdenada);
            String chave = new String(stringOrdenada);
            if (anagramas.containsKey(chave)){ // verifico se ja existe esse anagrama no hashmap
                int indice = anagramas.get(chave); // caso tenha só pego o indice dessa key
                resultado.get(indice).add(strs[i]); // adiciono a string na posicao da lista de lista
            }
            else {
                anagramas.put(chave, anagramas.size()); // caso nao exista, eu coloco ela num espaco novo
                List<String> novoGrupo = new ArrayList<>();
                novoGrupo.add(strs[i]); // crio um novo array pra lista e adiciono a string
                resultado.add(novoGrupo);
            }
        }

        return resultado;
    }
}
