class Owi535Logger:

    def __init__(self):
        print("Owi535 __init__")

    def RotateBase(self, value):
        print("Owi535 RotateBase:{}".format(value))

    def RotateShoulder(self, value):
        print("Owi535 RotateShoulder {}".format(value))

    def RotateElbow(self, value):
        print("Owi535 RotateElbow {}".format(value))

    def RotateWrist(self, value):
        print("Owi535 RotateWrist {}".format(value))

    def SwitchLight(self, value):
        print("Owi535 SwitchLight {}".format(value))

    def OpenGrip(self, value):
        print("Owi535 OpenGrip {}".format(value))

    def CloseGrip(self, value):
        print("Owi535 CloseGrip {}".format(value))
