function checkPart(part) {

    if (part === part.split("").reverse().join('')) {
        return true;
    }

    let arr = [...part];

    let position = 0;
    let isPalindrome = false;
    arr.forEach(() => {
        let temporal = [...part];
        temporal.splice(position, 1);

        if (temporal.join('') === temporal.reverse().join('')) {
            isPalindrome = true;
            return true;
        }

        position += 1;
    });

    return isPalindrome
}


console.log(checkPart("uwu")); // true
// "uwu" es un palíndromo sin eliminar ningún carácter

console.log(checkPart("miidim"));// true
// "miidim" puede ser un palíndromo después de eliminar la primera "i"
// ya que "midim" es un palíndromo

console.log(checkPart("midu")); // false
// "midu" no puede ser un palíndromo después de eliminar un carácter

