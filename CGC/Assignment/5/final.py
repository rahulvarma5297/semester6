import cv2
import numpy as np

cap = cv2.VideoCapture('video.mp4')
car_cascade = cv2.CascadeClassifier('cars.xml')

car_count = 0

while True:
    ret, frames = cap.read()
    gray = cv2.cvtColor(frames, cv2.COLOR_BGR2GRAY)
    cars = car_cascade.detectMultiScale(gray, 1.1, 9)

    for (x,y,w,h) in cars:
        plate = frames[y:y + h, x:x + w]
        cv2.rectangle(frames,(x,y),(x +w, y +h) ,(51 ,51,255),2)
        cv2.rectangle(frames, (x, y - 40), (x + w, y), (51,51,255), -2)
        cv2.putText(frames, 'Car', (x, y - 10), cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 255, 255), 2)
        cv2.imshow('car',plate)
        car_count += 1
        lab1 = "Car Count: " + str(car_count // 10)
        cv2.putText(frames, lab1, (40, 50), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)
        
        cv2.putText(frames, "Name: {}".format('RAHUL VARMA'), (10, 570), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)
        cv2.putText(frames, "Roll No: {}".format('S20200010212'), (10, 600), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)

    cv2.putText(frames, lab1, (40, 50), cv2.FONT_HERSHEY_SIMPLEX, 1, (147, 20, 255), 3)
    frames = cv2.resize(frames,(600,400))
    cv2.imshow('Car Detection System', frames)
    if cv2.waitKey(25) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()