function fixLetter(letter) {
    let formatted = letter
        .trim()
        .replaceAll(',', ', ')
        .replace(/  +/g, ' ')
        .replace(/([.,?!\s])(?=\1)/g, "") // remove duplicated mark
        .replace(/\s+([.,?!])/g, "$1") // remove space before mark
        .replace(/santa claus/ig, 'Santa Claus')
        .replace(/\b([.?!] [a-z])/g, m => m.toUpperCase()) // uppercase after (.?!)
        .replace(/^.*[a-zA-Z0-9]$/, m => m + '.') // dot at the end if ends with alphanumeric

    formatted = formatted[0].toUpperCase() + formatted.substring(1)

    return formatted
}

console.log(fixLetter(` hello,  how are you??     do you know if santa claus exists?  i really hope he does!  bye  `));
// Hello, how are you? Do you know if Santa Claus exists? I really hope he does! Bye.

console.log(fixLetter("  Hi Santa claus. I'm a girl from Barcelona , Spain . please, send me a bike.  Is it possible?"));
// Hi Santa Claus. I'm a girl from Barcelona, Spain. Please, send me a bike. Is it possible?
