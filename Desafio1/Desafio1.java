// O desafio feito é uma simples verificação de duplicados em um array
// Resolvido a partir de um HashSet, adiciona o num no hash e verifica
// se ele já foi adicionado anteriormente.

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}