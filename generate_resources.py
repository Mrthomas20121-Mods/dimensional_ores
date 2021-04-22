import json
import os
from PIL import Image, ImageChops, ImageColor, ImagePalette

os.chdir('src/main/resources/assets/dimensional_ores/')

Ores = [
    "copper",
    "tin",
    "silver",
    "lead",
    "uranium",
    "aluminum",
    "platinum",
    "nickel",
    "ardite",
    "cobalt",
    "osmium",
    "certus_quartz",
    "draconium"
]

Stones = [
    "holystone",
    "limestone",
    "foggy_stone",
    "umberstone",
    "trenchstone",
    "nightstone",
    "abyss_stone",
    "turquoise_stone",
    "lunar_stone",
    "gaia_stone",
    "moon_rock",
    "mars_stone",
    "asteroids_rock",
    "venus_stone",
    "triton_stone",
    "titania_stone",
    "jupiter_stone",
    "saturn_stone",
    "neptune_stone",
    "ceres_stone",
    "kepler22b_stone",
    "eris_stone",
    "mercury_stone",
    "titan_stone",
    "europa_stone",
    "io_stone",
    "deimos_stone",
    "phobos_stone",
    "callisto_stone",
    "ganymede_stone",
    "oberon_stone",
    "iapetus_stone",
    "rhea_stone",
    "diona_rock",
    "fronos_stone",
    "chalos_rock",
    "nibiru_rock",
    "betweenstone",
    "pitstone",
    "aurorianstone",
    "frozen_antinatric_stone",
    "kriffstone",
    "edenrock",
    "oasis",
    "purgot",
    "zolstone",
    "xantheon",
    "xanthian"
]

def del_none(d):
    """
    https://stackoverflow.com/a/4256027/4355781
    Modifies input!
    """
    for key, value in list(d.items()):
        if value is None:
            del d[key]
        elif isinstance(value, dict):
            del_none(value)
    return d

def blockstate(filename_parts, model, textures, variants=None, uvlock=None):
    """
    Magic.
    :param filename_parts: strings.
    :param model: String or None
    :param textures: Dict of <string>:<string> OR <iterable of strings>:<string>
    :param variants: Dict of <string>:<variant> OR "normal":None (to disable the normal default)
    """
    _variants = {
        'normal': [{}]
    }
    if variants:
        _variants.update(variants)

    p = os.path.join('blockstates', filename_parts) + '.json'
    os.makedirs(os.path.dirname(p), exist_ok=True)
    with open(p, 'w') as file:
        json.dump(del_none({
            '__comment': 'Generated by generateResources.py function: blockstate',
            'forge_marker': 1,
            'defaults': {
                'model': model,
                'textures': textures,
                'uvlock': True if uvlock else None
            },
            'variants': _variants
        }), file, indent=2)

def cube_all(filename_parts, texture, variants=None, model='cube_all'):
    blockstate(filename_parts, model, textures={'all': texture}, variants=variants)

for ore in Ores :
    for stone in Stones :
        name = "%s_%s_ore" % (stone, ore)
        cube_all(name, 'dimensional_ores:blocks/%s' % name)
        img1 = Image.open(os.path.join('textures', 'blocks', 'overlay_32' if stone == "asteroids_rock" else 'overlay', '%s.png' % ore)).convert("RGBA")
        img2 = Image.open(os.path.join('textures', 'blocks', 'stone', '%s.png' % stone)).convert("RGBA")
        result = Image.alpha_composite(img2, img1)
        result.save('./textures/blocks/%s.png' % name)