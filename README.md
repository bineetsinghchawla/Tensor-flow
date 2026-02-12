# Hand Gesture Classifier (Thumbs Up vs Thumbs Down) — Teachable Machine + TensorFlow.js

A simple real-time **hand gesture classifier** built using **Google Teachable Machine** (image model) and **TensorFlow.js**.  
It uses your webcam feed, runs predictions in the browser, and displays the confidence score for each class.

*Real-time testable link* 
https://tensor-flow-nu.vercel.app/

✅ **Classes trained**
- **Class 1:** 👍 Thumbs Up (41 image samples)
- **Class 2:** 👎 Thumbs Down (39 image samples)

---

## What this project does

- Opens your webcam in the browser
- Loads a Teachable Machine exported image model (`model.json` + `metadata.json`)
- Predicts your gesture continuously (frame-by-frame)
- Prints the prediction probabilities on screen

This is ideal as a beginner-friendly computer vision + browser ML project.

---

## Tech Stack

- Teachable Machine (Image Project → Export to TensorFlow.js)
- TensorFlow.js (via Teachable Machine `tmImage`)
- HTML + JavaScript (runs fully in the browser)



