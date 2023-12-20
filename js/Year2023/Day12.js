function checkIsValidCopy(original, copy) {

    if (original.length !== copy.length) return false

    for (let i = 0; i < copy.length; i++) {

        const originalChar = original[i]
        const copyChar = copy[i]

        if (originalChar !== copyChar &&
            (copyChar.toUpperCase() !== originalChar)
        ) {

            if (/^[a-zA-Z]$/.test(copyChar)) {
                return false
            }

            if (!isNaN(copyChar) && copyChar !== ' ') {
                return false
            }

            if (copyChar === ' ' &&
                (originalChar !== '.' &&
                    originalChar !== ':' &&
                    originalChar !== '+' &&
                    originalChar !== '#' &&
                    !/^[a-zA-Z]$/.test(originalChar))
            ) {
                return false
            }

            if (copyChar === '.' &&
                (originalChar !== ':' &&
                    originalChar !== '+' &&
                    originalChar !== '#' &&
                    !/^[a-zA-Z]$/.test(originalChar))
            ) {
                return false
            }

            if (copyChar === ':' &&
                (originalChar !== '+' &&
                    originalChar !== '#' &&
                    !/^[a-zA-Z]$/.test(originalChar))
            ) {
                return false
            }

            if (copyChar === '+' &&
                (originalChar !== '#' &&
                    !/^[a-zA-Z]$/.test(originalChar))
            ) {
                return false
            }

            if (copyChar === '#' &&
                (!/^[a-zA-Z]$/.test(originalChar))
            ) {
                return false
            }

        }

    }

    return true
}


console.log(checkIsValidCopy(
    'Santa Claus is coming',
    'sa#ta Cl#us i+ comin#'
)) // true
console.log(checkIsValidCopy(
    's#nta Cla#s is coming',
    'p#nt: cla#s #s c+min#'
)) // false (due to the initial p)
console.log(checkIsValidCopy('Santa Claus', 's#+:. c:. s')) // true
console.log(checkIsValidCopy('Santa Claus', 's#+:.#c:. s')) // false (there is a # where it shouldn't be)
console.log(checkIsValidCopy('Santa Claus', '###:. c:+##'))
