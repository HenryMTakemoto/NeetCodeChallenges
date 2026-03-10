// Desafio para ver se 2 strings são anagramas uma da outra
// Nessa solução usei dos próprios utilitários do Java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false; // caso não tenha o mesmo tamanho, não pode ser anagrama
        }

        char[] string1 = s.toCharArray(); // Transforma a string em Array
        char[] string2 = t.toCharArray();
        Arrays.sort(string1); // Ordena o array
        Arrays.sort(string2);
        return Arrays.equals(string1 , string2 ); // Compara o array
    }
}
