class tree(object):
    def __init__(self, data):
        self.data = data
        self.branches = []

    def __len__(self):
        return len(self.branches)

    def __eq__(self, other):
        return self.data == other.data

    def __ne__(self, other):
        return not self.__eq__(other)

    def addBranch(self, data):
        self.branches.append(tree(data))

    def getBranch(self, ix):
        return self.branches[ix]

    def getBranches(self):
        return self.branches

    def clear(self):
        self.branches = []

    def isLeaf(self):
        return self.branches == []

    def _get_leaves(self):
        result = []
        for child in self.branches:
            result.extend(child.leaves())
        if self.isLeaf():
            result.append(self)
        return result

    def leaves(self):
        list = self._get_leaves()

        # here check all leaves and get

        return list

    def search(self, item):
        result = []
        for child in self.branches:
            result.extend(child.search(item))
        if self.data == item:
            result.append(self)
        return result

    def __str__(self):
        return self.data.__str__()

    def __repr__(self):
        return "Tree(%s)" % (self.data)

    def __hash__(self):
        return hash(self.__repr__())

if __name__ == "__main__":
    pass