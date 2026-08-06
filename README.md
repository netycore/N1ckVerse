# N1ckVerse

A modernized Unicode character browser for Android — rebranded and upgraded from
[UnicodePad](https://github.com/Ryosuke839/UnicodePad) (Apache 2.0).

## What's new in N1ckVerse

- **Package**: `com.n1ckverse.unicode`
- **Min SDK**: 26 (Android 8.0 Oreo+)
- **Target SDK**: 34 (Android 14)
- **Themes**: Dark · Light · Light+DarkBar · Day/Night · **AMOLED (pure black)**
- **Modern APIs**: `PreferenceFragmentCompat`, `ActivityResultLauncher` (no more deprecated `startActivityForResult`/`onActivityResult`)
- **Theme-aware detail view**: character detail pane now uses theme colors instead of hardcoded Black/White
- **Repositories**: `jcenter()` removed; only `mavenCentral()` + `google()` + JitPack
- **Build**: Kotlin 1.9.22, Compose BOM 2024.02.00, Compose Kotlin Extension 1.5.8
- **Offline**: no `INTERNET` permission

## Preserved features (all of UnicodePad)

- Full Unicode 17.0 character database (SQLite, bundled)
- 7 tabs: Recent, List (Unicode blocks), Emoji, Find/Search, Favorites, Edit, RSIndex
- Unihan data (17 columns), emoji variants, tone/direction selectors
- Drag-to-reorder tabs and favorites
- Custom font loading from storage
- Export / import JSON backup
- PROCESS_TEXT integration (system text selection)
- Simeji keyboard integration
- `EmojiCompat` (bundled) support
- Locales: en, ja, zh, ko, ru, pt, sv, id, ka, and more

## Build

```bash
./gradlew :app:assembleFdroidDebug     # F-Droid (no ads)
./gradlew :app:assemblePlayDebug       # Play Store (ads)
```

## License

Apache License 2.0 — © Ryosuke839 (original UnicodePad) + N1ckVerse contributors.
