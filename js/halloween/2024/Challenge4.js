// https://www.halloween.dev/es/retos/2024/4

function findTheKiller(whisper, suspects) {
  const exactMatch = whisper.endsWith("$");
  if (exactMatch) {
    whisper = whisper.slice(0, -1);
  }

  let regexPattern = "^" + whisper.replace(/~/g, ".").replace(/\$$/, "\\$");

  if (exactMatch) {
    regexPattern += "$";
  }

  const regex = new RegExp(regexPattern, "i");

  const matches = suspects.filter((name) => regex.test(name));
  return matches.join(",");
}

console.log(
  findTheKiller("d~~~~~a", [
    "Dracula",
    "Freddy Krueger",
    "Jason Voorhees",
    "Michael Myers",
  ])
); // -> 'Dracula'

console.log(findTheKiller("~r~dd~", ["Freddy", "Freddier", "Fredderic"])); // -> 'Freddy,Freddier,Fredderic'

console.log(findTheKiller("~r~dd$", ["Freddy", "Freddier", "Fredderic"])); // -> ''

console.log(findTheKiller("mi~~def", ["Midudev", "Midu", "Madeval"])); // -> ''
