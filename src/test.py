#! /usr/bin/python3
from LogicUnit.flipflop import *
from LogicUnit.gate import *
from LogicUnit.inputx import *
from LogicUnit.outputz import *
from LogicUnit.table import *

def main():
	x = inputx()
	z = outputz()
	jk = JKflipflop()
	d = Dflipflop()
	state = table()
	
	state.addFlipFlop(jk)
	state.addFlipFlop(d)
	state.setInput(x)
	state.setOutput(z)

	and_array = [andGate() for _ in range(4)]
	or_array = [orGate() for _ in range(2)]
	not_array = [notGate() for _ in range(3)]

	jk.set(and_array[0])
	jk.set(or_array[0])
	d.set(or_array[1])
	z.set(and_array[3])

	not_array[0].set(x)
	not_array[1].set(jk)
	not_array[2].set(d)

	and_array[0].set(x)
	and_array[0].set(d)
	and_array[1].set(not_array[0])
	and_array[1].set(not_array[2])
	and_array[2].set(d)
	and_array[2].set(not_array[1])
	and_array[3].set(x)
	and_array[3].set(jk)
	and_array[3].set(not_array[2])

	or_array[0].set(x)
	or_array[0].set(not_array[2])
	or_array[1].set(and_array[1])
	or_array[1].set(and_array[2])

	result = state.run()
	table.toGraph(result)
	print('x=\t0\t1')
	for line in result:
		print(line[0]+'\t'+line[1][0][0]+' '+str(line[1][0][1])+'\t'+line[1][1][0]+' '+str(line[1][1][1]))
if __name__ == '__main__':
	main()
