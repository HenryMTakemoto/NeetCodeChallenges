// Desafio para verificar se a String é palíndromo.
class Solution {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove letras maiusculas e tira os caracteres nao-alfanumericos
        char[] string = s.toCharArray();  // transformo a string em array
        char[] stringInversa = new char[string.length]; 
        int j = string.length - 1; 

        for (int i = 0; i < string.length; i++) {
            stringInversa[i] = string[j]; // vou fazendo a string inversa 
            j--;
        }

        return Arrays.equals(string, stringInversa); // comparo se o conteúdo é o mesmo
    }
}