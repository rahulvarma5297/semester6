import cv2
import numpy as np

cap = cv2.VideoCapture('video.mp4')
car_cascade = cv2.CascadeClassifier('cars.xml')

while True:
    ret, frames1 = cap.read()
    ret, frames2 = cap.read()
    gray = cv2.cvtColor(frames1, cv2.COLOR_BGR2GRAY)

    # For Motion:
    cars = car_cascade.detectMultiScale(gray, 1.1, 9)
    diff = cv2.absdiff(frames1, frames2)

    # For Motion:
    diff_gray = cv2.cvtColor(diff, cv2.COLOR_BGR2GRAY)
    blur = cv2.GaussianBlur(diff_gray, (5, 5), 0)

    # For Car:
    _, thresh = cv2.threshold(blur, 20, 255, cv2.THRESH_BINARY)
    dilated = cv2.dilate(thresh, None, iterations=3)

    contours, _ = cv2.findContours(dilated, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    
    # For Motion:
    for contour in contours:
        (x, y, w, h) = cv2.boundingRect(contour)
        if cv2.contourArea(contour) < 1000:
            continue
        cv2.rectangle(frames1, (x, y), (x + w, y + h), (0, 0, 255), 2)
        cv2.putText(frames1, 'Motion', (x, y - 10),
                    cv2.FONT_HERSHEY_SIMPLEX, 0.7, (255, 255, 255), 2)
        
    # For Car:
    for (x, y, w, h) in cars:
        plate = frames1[y:y + h, x:x + w]
        cv2.rectangle(frames1, (x, y), (x + w, y + h), (51, 51, 255), 2)
        cv2.rectangle(frames1, (x, y - 40), (x + w, y), (51, 51, 255), -2)
        cv2.putText(frames1, 'Harr', (x, y - 10),
                    cv2.FONT_HERSHEY_SIMPLEX, 0.7, (255, 255, 255), 2)
        cv2.imshow('car', plate)

    frames1 = cv2.resize(frames1, (600, 400))
    cv2.putText(frames1, "Name: {}".format('RAHUL VARMA'), (10, 570), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)
    cv2.putText(frames1, "Roll No: {}".format('S20200010212'), (10, 600), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)

    cv2.imshow('Car Detection System', frames1)
    if cv2.waitKey(25) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()