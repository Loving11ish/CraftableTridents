package me.loving11ish.craftabletridents;

import me.loving11ish.craftabletridents.Recipies.tridentRecipe;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class craftableTridents extends JavaPlugin {

    public static craftableTridents plugin;
    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")||
                Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||
                Bukkit.getServer().getVersion().contains("1.17"))){
            logger.warning(ChatColor.RED + "-------------------------------------------");
            logger.warning(ChatColor.RED + "CraftableTridents - This plugin is only supported on the Minecraft versions listed below:");
            logger.warning(ChatColor.RED + "CraftableTridents - 1.13.x");
            logger.warning(ChatColor.RED + "CraftableTridents - 1.14.x");
            logger.warning(ChatColor.RED + "CraftableTridents - 1.15.x");
            logger.warning(ChatColor.RED + "CraftableTridents - 1.16.x");
            logger.warning(ChatColor.RED + "CraftableTridents - 1.17.x");
            logger.warning(ChatColor.RED + "CraftableTridents - Is now disabling!");
            logger.warning(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(this);
        }else {
            logger.info(ChatColor.GREEN + "-------------------------------------------");
            logger.info(ChatColor.GREEN + "CraftableTridents - A supported Minecraft version has been detected");
            logger.info(ChatColor.GREEN + "CraftableTridents - Continuing plugin startup");
            logger.info(ChatColor.GREEN + "-------------------------------------------");
        }

        // Plugin startup logic
        plugin = this;
        tridentRecipe recipe = new tridentRecipe();
        recipe.unEnchantedRecipe();
        recipe.enchantedRecipe();

        //Plugin startup message
        logger.info("-------------------------------------------");
        logger.info(ChatColor.AQUA + "CraftableTridents - Plugin By Loving11ish");
        logger.info(ChatColor.AQUA + "CraftableTridents - has been loaded successfully!");
        logger.info(ChatColor.AQUA + "CraftableTridents - Plugin Version " + pluginVersion);
        logger.info("-------------------------------------------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.clearRecipes();

        //Plugin shutdown message
        logger.info("-------------------------------------------");
        logger.info(ChatColor.AQUA + "CraftableTridents - Plugin By Loving11ish");
        logger.info(ChatColor.AQUA + "CraftableTridents - has been disabled successfully!");
        logger.info("-------------------------------------------");
    }

    public static craftableTridents getPlugin() {
        return plugin;
    }
}
