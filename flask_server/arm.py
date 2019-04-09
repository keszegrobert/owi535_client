import time

from owi535logger import Owi535Logger
from flask import Flask
from flask import request

arm = Owi535Logger()
app = Flask(__name__)


@app.route('/task', methods=['POST'])
def postJsonHandler():
    content = request.form.to_dict()
    print (content)

    direction = 0
    if 'dir' in content:
        direction = float(content['dir'])

    if 'part' in content:
        if content['part'] == 'base':
            arm.RotateBase(direction)
        elif content['part'] == 'shoulder':
            arm.RotateShoulder(direction)
        elif content['part'] == 'elbow':
            arm.RotateElbow(direction)
        elif content['part'] == 'wrist':
            arm.RotateWrist(direction)
        elif content['part'] == 'led':
            arm.SwitchLight(direction)
        elif content['part'] == 'grip':
            arm.OpenGrip(direction)
        elif content['part'] == 'grip':
            arm.CloseGrip(direction)
        else:
            raise Exception('no such part: "{}"'.format(content['part']))

    if 'time' in content:
        interval = float(content['time'])
        if interval > 2.0:
            raise Exception('Time interval too long')
        if interval <= 0.0:
            raise Exception('Time interval too small')

        arm.StartMove()
        time.sleep(interval)
        arm.StopMove()

    return '\n'


app.run(host='0.0.0.0', port=5351)
