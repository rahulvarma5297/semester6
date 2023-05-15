import cv2
cap = cv2.VideoCapture('video.mp4')
clahe = cv2.createCLAHE(clipLimit=2.0, tileGridSize=(8,8))
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
    grouped_cnts = []
    for c in cnts:
        if cv2.contourArea(c) < 3000:
            continue
        (x, y, w, h) = cv2.boundingRect(c)
        if len(grouped_cnts) == 0:
            grouped_cnts.append([x, y, w, h])
        else:
            found_group = False
            for group in grouped_cnts:
                if abs(x - group[0]) < 100 and abs(y - group[1]) < 100:
                    group[0] = min(group[0], x)
                    group[1] = min(group[1], y)
                    group[2] = max(group[2], x + w - group[0])
                    group[3] = max(group[3], y + h - group[1])
                    found_group = True
                    break
            if not found_group:
                grouped_cnts.append([x, y, w, h])
    for group in grouped_cnts:
        x, y, w, h = group
        if w > 100:
            if len(grouped_cnts) > 2:
                cv2.rectangle(frame1, (x, y), (x + w, y + h), (0, 0, 255), 2)
            else:
                cv2.rectangle(frame1, (x, y), (x + w, y + h), (0, 255, 0), 2)
            cv2.putText(frame1, "Status: {}".format('TRAFFIC DETECTED'), (10, 90), cv2.FONT_HERSHEY_SIMPLEX, 1, (255,255,0), 3)
            cv2.putText(frame1, "Status: {}".format('RAHUL VARMA'), (10, 120), cv2.FONT_HERSHEY_SIMPLEX, 1, (255,255,0), 3)
            cv2.putText(frame1, "Status: {}".format('S20200010212'), (10, 150), cv2.FONT_HERSHEY_SIMPLEX, 1, (255,255,0), 3)
        else:
            cv2.rectangle(frame1, (x, y), (x + w, y + h), (0, 255, 0), 2)
    cv2.putText(frame1, "Status: {}".format('Press Q to exit'), (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 3)
    cv2.imshow('frame', frame1)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()
