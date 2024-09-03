const browserAPI = (typeof browser !== 'undefined') ? browser : chrome;

browserAPI.runtime.onInstalled.addListener(() => {
  browserAPI.contextMenus.create({
    id: "translateText",
    title: "Translate '%s'",
    contexts: ["selection"]
  });
});

browserAPI.contextMenus.onClicked.addListener((info, tab) => {
  if (info.menuItemId === "translateText") {
    browserAPI.storage.sync.get('targetLanguage', (data) => {
      const targetLanguage = data.targetLanguage || 'en'; // Default to English if no language is set
      browserAPI.scripting.executeScript({
        target: { tabId: tab.id },
        func: translateText,
        args: [info.selectionText, targetLanguage]
      });
    });
  }
});

function translateText(selectedText, targetLanguage) {
  const encodedText = encodeURIComponent(selectedText);
  const url = `https://translate.googleapis.com/translate_a/single?client=gtx&sl=auto&tl=${targetLanguage}&dt=t&q=${encodedText}`;

  fetch(url)
    .then(response => response.json())
    .then(data => {
      const translatedText = data[0].map(segment => segment[0]).join(' ');
      alert(`Translated Text: ${translatedText}`);
    })
    .catch(error => console.error('Error:', error));
}
