class JKflipflop:
	def __init__(self):
		self.J = None
		self.K = None
		self.output = None
		self.count = 0

	def setJ(self, J):
		self.J = J
	
	def setK(self, K):
		self.K = K

	def set(self, x):
		if self.count == 0:
			self.setJ(x)
			self.count += 1
		elif self.count == 1:
			self.setK(x)
			self.count += 1

	def setOutput(self, o):
		self.output = o
	
	def deleteJ(self):
		self.J = None

	def deleteK(self):
		self.K = None
	
	def getOutput(self):
		return self.output

	def getNextState(self):
		J = self.J.getOutput()
		K = self.K.getOutput()
		if J == 0 and K == 0:
			return self.output
		if J == 0 and K == 1:
			return False
		if J == 1 and K == 0:
			return True
		if J == 1 and K == 1:
			return not self.output

class RSflipflop:
	def __init__(self):
		self.R = None
		self.S = None
		self.output = None
		self.count = 0
	
	def setR(self, R):
		self.R = R
	
	def setS(self, S):
		self.S = S

	def set(self, x):
		if self.count == 0:
			self.setR(x)
			self.count += 1
		elif self.count == 1:
			self.setS(x)
			self.count += 1

	def setOutput(self, o):
		self.output = o
	
	def deleteR(self):
		self.R = None

	def deleteS(self):
		self.S = None
	
	def getOutput(self):
		return self.output

	def getNextState(self):
		R = self.R.getOutput()
		S = self.S.getOutput()
		if R == 0 and S == 0:
			return self.output
		if R == 1 and S == 0:
			return False
		if R == 0 and S == 1:
			return True
		if R == 1 and S == 1:
			return not self.output

class Dflipflop:
	def __init__(self):
		self.D = None
		self.output = None
	
	def set(self, D):
		self.D = D

	def setOutput(self, o):
		self.output = o
	
	def deleteD(self):
		self.D = None
	
	def getOutput(self):
		return self.output

	def getNextState(self):
		return self.D.getOutput()

class Tflipflop:
	def __init__(self):
		self.T = None
		self.output = None
	
	def set(self, T):
		self.T = T

	def setOutput(self, o):
		self.output = o
	
	def deleteT(self):
		self.T = None
	
	def getOutput(self):
		return self.output

	def getNextState(self):
		T = self.T.getOutput()
		if T:
			return not self.output
		else:
			return self.output
