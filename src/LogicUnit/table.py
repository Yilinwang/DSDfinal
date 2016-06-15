from itertools import permutations
from graphviz import Digraph
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

	def _listToString(x):
		return ''.join(['1' if i else '0' for i in x])

	def _boolToString(x):
		return '1' if x else '0'
	
	def toGraph(result):
		state = Digraph()
		for s in result:
			state.node(s[0], s[0])
		for s in result:
			state.edge(s[0], s[1][0][0], label='0/'+s[1][0][1])
			state.edge(s[0], s[1][1][0], label='1/'+s[1][1][1])
		state.render('test.gv', view=True)
		with open('log', 'w') as wp:
			wp.write('x=\t0\t1\n')
			for line in result:
				wp.write(line[0]+'\t'+line[1][0][0]+' '+str(line[1][0][1])+'\t'+line[1][1][0]+' '+str(line[1][1][1])+'\n')


	def run(self):
		c = permutations([True]*len(self.flipflops)+[False]*len(self.flipflops), len(self.flipflops))
		result = []
		for p in sorted(set(c)):
			result.append((table._listToString(p), []))
			for b in [False, True]:
				self.i.setX(b)
				for i in range(len(self.flipflops)):
					self.flipflops[i].setOutput(p[i])
				result[-1][-1].append((table._listToString([ff.getNextState() for ff in self.flipflops]), table._boolToString(self.o.getNextState())))
		return result
