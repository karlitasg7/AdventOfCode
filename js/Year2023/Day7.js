function drawGift(size, symbol) {

    const lineSymbol = '#'
    const repeatSymbol = symbol.repeat(Math.max(0, size - 2))

    let part1 = []
    let part2 = []

    for (let i = 0; i < size - 1; ++i) {

        let line = ''

        if (i === 0) {
            line = lineSymbol.repeat(size)
        } else {
            line = `${lineSymbol}${repeatSymbol}${lineSymbol}${symbol.repeat(i - 1)}${lineSymbol}`
        }

        part1.push(`${' '.repeat(size - i - 1)}${line}`)
        part2.unshift(line)

    }

    const b = lineSymbol.repeat(size)
    const middleLine = size > 1 ? `\n${b}${repeatSymbol}${lineSymbol}\n` : lineSymbol

    return part1.join('\n') + middleLine + part2.join('\n') + '\n'
}

console.log(drawGift(4, '+'))

/*
   ####
  #++##
 #++#+#
####++#
#++#+#
#++##
####
*/

console.log(drawGift(5, '*'))
/*
    #####
   #***##
  #***#*#
 #***#**#
#####***#
#***#**#
#***#*#
#***##
#####
*/

console.log(drawGift(1, '^'))
/*
#
*/
