package betamindy.world.blocks.distribution;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.world.*;
import mindustry.gen.*;

import static arc.Core.atlas;

public class SlimeBlock extends Block {
    public int slimeType;
    public Color color;
    public TextureRegion coreRegion;
    public SlimeBlock(String name, int stype){
        super(name);
        slimeType = stype;
        update = true;
        solid = true;
        rotate = false;
        category = Category.distribution;
    }

    @Override
    public void load(){
        super.load();
        coreRegion = atlas.find(name + "-core");
    }

    public class SlimeBuild extends Building{
        @Override
        public void draw(){
            if(Core.settings.getBool("animatedshields") && Core.settings.getBool("slimeeffect")){
                Draw.rect(coreRegion, x, y);
                Draw.z(Layer.shields);
                Draw.color(color);
                Fill.square(x, y, 4f);
                Draw.reset();
            }
            else super.draw();
        }
    }
}