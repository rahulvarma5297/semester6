import cv2
cap = cv2.VideoCapture('video.mp4')
clahe = cv2.createCLAHE(clipLimit=2.0, tileGridSize=(8,8))
count_in = 0
count_out = 0
height, width, _ = cap.read()[1].shape
line_y = int(height / 4)
left_boundary = int(width / 3)
right_boundary = int(2 * width / 3)
while True:
    ret, frame1 = cap.read()
    gray1 = cv2.cvtColor(frame1, cv2.COLOR_BGR2GRAY)
    gray1 = clahe.apply(gray1)
    ret, frame2 = cap.read()
    gray2 = cv2.cvtColor(frame2, cv2.COLOR_BGR2GRAY)
    gray2 = clahe.apply(gray2)
    diff = cv2.absdiff(gray1, gray2)
    thresh = cv2.threshold(diff, 25, 255, cv2.THRESH_BINARY)[1]
    dilated = cv2.dilate(thresh, None, iterations=2)
    cnts, _ = cv2.findContours(dilated, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    for c in cnts:
        if cv2.contourArea(c) < 2500:
            continue
        (x, y, w, h) = cv2.boundingRect(c)
        cv2.rectangle(frame1, (x, y), (x + w, y + h), (0, 255, 0), 2)
        center = (int((x+x+w)/2),int((y+y+h)/2))
        if center[0] < left_boundary:
            count_in += 1
        elif center[0] > right_boundary:
            count_out += 1
        cv2.putText(frame1, "In: {}".format(str(count_in // 100)), (10, 90), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 4)
        cv2.putText(frame1, "Out: {}".format(str(count_out // 100)), (10, 120), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 4)
        cv2.putText(frame1, "Status: {}".format('RAHUL VARMA'), (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)
        cv2.putText(frame1, "Status: {}".format('S20200010212'), (10, 60), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 3)
        if center[1] > line_y:
            cv2.putText(frame1, "Vehicle crossing", (center[0] - 50, center[1] - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 0, 255), 2)
            if center[1] > line_y+10: 
                count_crossed = count_in if center[0] < left_boundary else count_out
                count_crossed += 1
                if center[0] < left_boundary:
                    count_in = count_crossed
                else:
                    count_out = count_crossed
                cv2.line(frame1, (0, line_y+10), (width, line_y+10), (255, 0, 0), 2)
    cv2.imshow('frame', frame1)
    if cv2.waitKey(25) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()