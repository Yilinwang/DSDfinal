from itertools import permutations

class table:
	def __init__(self):
		self.flipflops = []
		self.i = None
		self.o = None
	
	def addFlipFlop(self, ff):
		self.flipflops.append(ff)

	def setInput(self, i):
		self.i = i
	
	def setOutput(self, o):
		self.o = o
	
	def deleteFlipFlop(self, ff):
		self.flipflops.remove(ff)

	def _toString(x):
		return ''.join(['1' if i else '0' for i in x])

	def run(self):
		c = permutations([True]*len(self.flipflops)+[False]*len(self.flipflops), len(self.flipflops))
		result = []
		for p in sorted(set(c)):
			result.append((table._toString(p), []))
			for b in [False, True]:
				self.i.setX(b)
				for i in range(len(self.flipflops)):
					self.flipflops[i].setOutput(p[i])
				result[-1][-1].append((table._toString([ff.getNextState() for ff in self.flipflops]), self.o.getNextState()))
		return result
