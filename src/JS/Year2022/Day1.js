function wrapping(gifts) {
    return gifts.map(element => {
        let wrapped = "*".repeat(element.length + 2);
        return `${wrapped}\n*${element}*\n${wrapped}`;
    });
}

const gifts = ['cat', 'game', 'socks']
const wrapped = wrapping(gifts)

console.log(wrapped)
/* [
  "*****\\n*cat*\\n*****",
  "******\\n*game*\\n******",
  "*******\\n*socks*\\n*******"
] */
