# MinecraftPing
A plugin that allows to ping locations
![image](https://user-images.githubusercontent.com/22856090/177138528-c5cfd653-324d-4026-af34-467527c732d6.png)
Due to a technical limitation the beam is created using particles (Plugins are server-side, so it's not possible to do
things like an overlay)

## Usage
Just look at where you want to ping and sneak fast two times in a row

## Installation
Just put the latest [release jar](https://github.com/Huber1/MinecraftPing/releases) into your plugins folder
and restart the server to make it work

## Versions
1.17, 1.18, 1.19

### For earlier versions:
1. update spigot dependency in `build.gradle` to desired version
2. set `api-version` in ``plugin.yml`` to the same version
3. go to `Listeners.java` and set the Particle type (Line 53) to something that exists already in that version
4. This _should_ work, I didn't test it though