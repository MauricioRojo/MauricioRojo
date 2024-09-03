#Highlight Translator
### Video Demo: https://youtu.be/tupj8wV1TBo
## Description

Highlight Translator is a versatile and user-friendly browser extension designed to seamlessly integrate with any search engine or webpage. This extension empowers users by translating any text they highlight into their desired language, with the default set to English. However, the flexibility of the tool allows users to choose from a variety of other languages, making it an indispensable resource for anyone navigating multilingual content online.

## Features

- **Multilingual Translation**: By default, the extension translates highlighted text into English. Users can choose from other languages like Spanish, French, German, Chinese (Simplified), or Japanese.
- **Simple Interface**: The extension provides an easy-to-use dropdown menu to select your preferred language. Save your choice with a single click.
- **Context Menu Integration**: The extension adds a "Translate '%s'" option to the right-click menu, making it easy to translate text without disrupting your browsing experience.
- **Efficient Translation**: The extension translates text quickly using the Google Translate API and displays the result in a convenient alert box.
- **Handles Multiple Sentences**: Capable of translating entire paragraphs, with scrollable alert boxes to ensure you see the full translation.

## How It Works

Once installed and running, **Highlight Translator** is ready to translate any text you highlight. The default translation language is English, but this can be easily changed:

1. Access your active browser extensions.
2. Click on the **Highlight Translator** extension icon.
3. A small popup window will appear with a dropdown menu to select your desired language (English, Spanish, French, German, Chinese, Japanese).
4. After making your selection, click the **Save** button to store your preference.

To use the extension:

1. Highlight the text you wish to translate on any webpage.
2. Right-click and choose the **Translate '%s'** option from the context menu.
3. An alert box will appear with the translated text.

If the text is lengthy, simply scroll down within the alert box to view the full translation.

## Technical Overview

### background.js

- **Cross-Browser Compatibility**: The background script is designed to work across different browsers, including Chrome and Firefox.
- **Context Menu**: It adds a "Translate '%s'" option to the right-click menu, allowing easy access to the translation feature.
- **Translation Process**: When the "Translate" option is selected, the script retrieves the highlighted text and sends it to the Google Translate API. The API detects the original language and translates it to the target language, which is either the default English or the language chosen by the user.

### popup.html

- **User Interface**: This HTML file creates the interface for selecting the target language. When the user clicks on the extension icon, a popup window appears with a dropdown menu offering language options.
- **Save Functionality**: After selecting a language, the user must click **Save** to store their preference. A confirmation alert is displayed after saving.

### popup.js (Embedded in popup.html)

- **Language Storage**: The script saves the user's language preference using `browserAPI.storage.sync`, ensuring the choice is retained across sessions.
- **Default Language**: The extension defaults to English if no other language is selected. Users can change this by selecting a different language in the popup and clicking **Save**.
- **Confirmation**: After saving a new language preference, an alert box confirms the change.

## Development Decisions

The initial concept for **Highlight Translator** included redirecting users to a separate HTML page to view the translation. However, to maintain simplicity and focus on user experience, the translation is now displayed directly in an alert box on the same page. This decision enhances the user experience by minimizing disruptions and keeping the process streamlined.

Another key decision was to offer multiple language options instead of limiting the translation to English. This choice significantly increased the extension's utility and appeal, making it a valuable tool for a global audience.
