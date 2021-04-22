package stardust_binding.dimensional_ores.api.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.GenericEvent;
import net.minecraftforge.fml.common.eventhandler.IContextSetter;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Events {

    public static class PreEvent<T extends IForgeRegistryEntry<T>> extends GenericEvent<T> implements IContextSetter
    {
        private final IForgeRegistry<T> registry;
        private final ResourceLocation name;

        public PreEvent(ResourceLocation name, IForgeRegistry<T> registry)
        {
            super(registry.getRegistrySuperType());
            this.name = name;
            this.registry = registry;
        }

        public IForgeRegistry<T> getRegistry()
        {
            return registry;
        }

        public ResourceLocation getName()
        {
            return name;
        }

    }

}

