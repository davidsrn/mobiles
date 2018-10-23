import time
import RPi.GPIO as GPIO

button = 19
green=20
yellow=21
red=22

music='music.wav'
pygame.mixer.init()

tiempo=0
high=GPIO.HIGH
low=GPIO.LOW
notpressed=0
bandera=True

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.setup(green,GPIO.OUT)
GPIO.setup(red,GPIO.OUT)
GPIO.setup(yellow,GPIO.OUT)

GPIO.setup(button,GPIO.IN)

pins=[green, red, yellow]

banderalista=True

def apretar(notpressed, banderalista):
	pressed = GPIO.input(button)
	if((not notpressed) and pressed):
		print("apreto el button")
		if banderalista==True:
			banderalista=False
		elif banderalista==False:
			banderalista=True

	notpressed = pressed
	return banderalista

while True:

    banderalista=apretar(notpressed, banderalista)

    if(banderalista==True):
    	GPIO.output(red,high)
    	time.sleep(3)
    	GPIO.output(red,low)
    	GPIO.output(green,high)
    	time.sleep(3)
    	GPIO.output(green,low)
    	GPIO.output(yellow,high)
    	time.sleep(1)
    	GPIO.output(yellow,low)
        GPIO.output(yellow,high)
    	time.sleep(1)
    	GPIO.output(yellow,low)
        GPIO.output(yellow,high)
    	time.sleep(1)
    	GPIO.output(yellow,low)
