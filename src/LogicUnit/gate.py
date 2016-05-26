class Gate:
	def __init__(self):
		self.inputs = []
	
	def set(self, x):
		self.inputs.append(x)

	def delete(self, x):
		self.inputs.remove(x)

class andGate(Gate):
	def getOutput(self):
		ans = True
		for i in self.inputs:
			ans &= i.getOutput()
		return ans

class orGate(Gate):
	def getOutput(self):
		ans = False
		for i in self.inputs:
			ans |= i.getOutput()
		return ans

class xorGate(Gate):
	def getOutput(self):
		ans = False
		for i in self.inputs:
			ans ^= i.getOutput()
		return ans

class nandGate(Gate):
	def getOutput(self):
		ans = True
		for i in self.inputs:
			ans &= i.getOutput()
		return not ans

class norGate(Gate):
	def getOutput(self):
		ans = False
		for i in self.inputs:
			ans |= i.getOutput()
		return not ans
class notGate():
	def __init__(self):
		self.x = None
	def set(self, x):
		self.x = x
	def delete(self):
		self.x = None
	def getOutput(self):
		return not self.x.getOutput()
