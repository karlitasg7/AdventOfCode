function findNaughtyStep(original, modified) {

    if (original === modified) return '';

    if (modified.length > original.length) {
        for (let i = 0; i < modified.length; i++) {
            if (original[i] !== modified[i]) {
                return modified[i];
            }
        }
    } else {
        for (let i = 0; i < original.length; i++) {
            if (original[i] !== modified[i]) {
                return original[i];
            }
        }
    }

    return ''
}


console.log(findNaughtyStep('abcd', 'abcde')); // 'e'
console.log(findNaughtyStep('stepfor', 'stepor')); // 'f'
console.log(findNaughtyStep('abcde', 'abcde')); // ''
