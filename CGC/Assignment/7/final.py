import cv2
face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')

EYE_COUNT_THRESH = 1
cap = cv2.VideoCapture(0)

while True:
    ret, frame = cap.read()
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.3, 5)

    # Loop through each face
    for (x,y,w,h) in faces:
        # Draw a rectangle around the face
        cv2.rectangle(frame,(x,y),(x+w,y+h),(255,0,0),2)        
        gray = gray[y:y+h, x:x+w]
        frame_color = frame[y:y+h, x:x+w]
        eyes = eye_cascade.detectMultiScale(gray)

        count = 0
        for (ex,ey,ew,eh) in eyes:
            cv2.rectangle(frame_color,(ex,ey),(ex+ew,ey+eh),(0,255,0),2)
            count += 1

        if count < EYE_COUNT_THRESH:
            cv2.putText(frame, "closed", (x, y - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 0, 255), 2)
            cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 0, 255), 2)
        else:
            cv2.putText(frame, "opened", (x, y - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 255, 0), 2)
            cv2.putText(frame, "Name: {}".format('RAHUL VARMA'), (10, 60), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3) 
            cv2.putText(frame, "Roll No: {}".format('S20200010212'), (10, 90), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)
            cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)

    cv2.imshow('Eyes Detector', frame)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()