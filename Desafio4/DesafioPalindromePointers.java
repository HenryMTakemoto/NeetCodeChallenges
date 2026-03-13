// Solucao de forma onde um ponteiro começa pelo final e o outro pelo começo
// Até se encontrarem, se não ocorrer é porque não é palindromo
class Solution {
    public boolean isPalindrome(String s) {
        int esquerda = 0;
        int direita = s.length() - 1;

        while (esquerda < direita) {
            char charEsq = s.charAt(esquerda);
            char charDir = s.charAt(direita);

            if (!Character.isLetterOrDigit(charEsq)) {
                esquerda++;
            } else if (!Character.isLetterOrDigit(charDir)) {
                direita--;
            } else {
                if (Character.toLowerCase(charEsq) != Character.toLowerCase(charDir)) {
                    return false;
                }
                esquerda++;
                direita--;
            }
        }
        
        return true;
    }
}