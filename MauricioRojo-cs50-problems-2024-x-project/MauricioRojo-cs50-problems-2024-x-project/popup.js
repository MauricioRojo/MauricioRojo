const browserAPI = (typeof browser !== 'undefined') ? browser : chrome;
document.getElementById('save').addEventListener('click', () => {
  const selectedLanguage = document.getElementById('language').value;
  browserAPI.storage.sync.set({ targetLanguage: selectedLanguage }, () => {
    alert('Language saved!');
  });
});
