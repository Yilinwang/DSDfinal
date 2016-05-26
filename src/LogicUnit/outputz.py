class outputz:
	def __init__(self):
		self.i = None
	
	def setInput(self, x):
		self.i = x
	
	def deleteInput(self):
		self.i = None
	
	def getNextState(self):
		return self.i.getOutput()
