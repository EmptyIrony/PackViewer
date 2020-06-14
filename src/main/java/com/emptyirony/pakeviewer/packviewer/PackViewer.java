package com.emptyirony.pakeviewer.packviewer;

import com.emptyirony.pakeviewer.packviewer.listener.PlayerListener;
import lombok.Getter;
import net.jitse.npclib.NPCLib;
import net.jitse.npclib.hologram.Hologram;
import net.jitse.npclib.internal.MinecraftVersion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import strafe.games.miku.util.CC;
import strafe.games.miku.util.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class PackViewer extends JavaPlugin {
    @Getter
    private static PackViewer ins;

    private NPCLib npcLib;
    private boolean canJoin = false;
    private Hologram hologram;

    @Override
    public void onEnable() {
        ins = this;
        npcLib = new NPCLib(this);

        this.getServer().getPluginManager().registerEvents(new PlayerListener(this),this);
        // Plugin startup logic

        new BukkitRunnable() {
            @Override
            public void run() {
                canJoin = true;
            }
        }.runTaskLater(this,20*5);
        List<String> text = new ArrayList<>();
        text.add(CC.translate("&bStrafeKits&e Showcase Room"));
        hologram = new Hologram(MinecraftVersion.V1_8_R3,new Location(Bukkit.getWorld("Lobby"),5,55,27),text);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
