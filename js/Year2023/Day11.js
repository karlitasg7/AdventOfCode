function getIndexsForPalindrome(word) {

    if (word === word.split("").reverse().join('')) {
        return [];
    }

    for (let i = 0; i < word.length; i++) {
        for (let j = i + 1; j < word.length; j++) {

            const tempWord = [...word];
            const temp = tempWord[i]
            tempWord[i] = tempWord[j]
            tempWord[j] = temp

            if (tempWord.join('') === tempWord.reverse().join('')) {
                return [i, j];
            }
        }
    }

    return null;
}

console.log(getIndexsForPalindrome('anna')) // []
console.log(getIndexsForPalindrome('abab')) // [0, 1]
console.log(getIndexsForPalindrome('abac')) // null
console.log(getIndexsForPalindrome('aaaaaaaa')) // []
console.log(getIndexsForPalindrome('aaababa')) // [1, 3]
console.log(getIndexsForPalindrome('caababa')) // null
