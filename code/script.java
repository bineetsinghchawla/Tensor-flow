const MODEL_URL = "./model/";

let model, webcam, labelContainer, maxPredictions;

async function init() {
  try {
    const modelURL = MODEL_URL + "model.json";
    const metadataURL = MODEL_URL + "metadata.json";

    model = await tmImage.load(modelURL, metadataURL);
    maxPredictions = model.getTotalClasses();

    const flip = true;
    webcam = new tmImage.Webcam(200, 200, flip);
    await webcam.setup();
    await webcam.play();
    window.requestAnimationFrame(loop);

    const webcamContainer = document.getElementById("webcam-container");
    labelContainer = document.getElementById("label-container");

    webcamContainer.innerHTML = "";
    labelContainer.innerHTML = "";

    webcamContainer.appendChild(webcam.canvas);
    for (let i = 0; i < maxPredictions; i++) {
      labelContainer.appendChild(document.createElement("div"));
    }
  } catch (err) {
    console.error(err);
    alert("Init failed: " + err.message);
  }
}

async function loop() {
  webcam.update();
  await predict();
  window.requestAnimationFrame(loop);
}

async function predict() {
  const prediction = await model.predict(webcam.canvas);

  for (let i = 0; i < maxPredictions; i++) {
    labelContainer.children[i].textContent =
      `${prediction[i].className}: ${prediction[i].probability.toFixed(2)}`;
  }
}
