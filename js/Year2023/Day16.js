function transformTree(tree) {
    function buildLeaf(tree, index) {
        const value = tree[index]
        if (value != null) {
            const base = index * 2
            return {
                value: value,
                left: buildLeaf(tree, base + 1),
                right: buildLeaf(tree, base + 2)
            }
        }
        return null
    }

    const result = buildLeaf(tree, 0);
    return result;
}

console.log(transformTree([3, 1, 0, 8, 12, null, 1]))
