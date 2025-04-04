package org.bukkit.craftbukkit.inventory;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.junit.jupiter.params.provider.Arguments;

public class ItemStackLoreEnchantmentTest extends ItemStackTest {

    public static Stream<Arguments> data() {
        return StackProvider.compound(ItemStackLoreEnchantmentTest.operators(), "%s %s", NAME_PARAMETER, ItemStackTest.COMPOUND_MATERIALS);
    }

    @SuppressWarnings("unchecked")
    static List<Object[]> operators() {
        return CompoundOperator.compound(
            Joiner.on('+'),
            NAME_PARAMETER,
            ~0L,
            Arrays.asList(
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setLore(Arrays.asList("First Lore", "Second Lore"));
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "Lore vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setLore(Arrays.asList("Some lore"));
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Lore vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setLore(Arrays.asList("Some more lore", "Another lore"));
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setLore(Arrays.asList("Some more lore"));
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Lore vs Other"
                }
            ),
            Arrays.asList(
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setDisplayName("TestItemName");
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "Name vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setDisplayName("AnotherItemName");
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Name vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setDisplayName("The original ItemName");
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.setDisplayName("The other name");
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Name vs Other"
                }
            ),
            Arrays.asList(
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            cleanStack.addUnsafeEnchantment(Enchantment.EFFICIENCY, 2);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "EnchantStack vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            cleanStack.addUnsafeEnchantment(Enchantment.RESPIRATION, 1);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "EnchantStack vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            cleanStack.addUnsafeEnchantment(Enchantment.POWER, 1);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            cleanStack.addUnsafeEnchantment(Enchantment.FLAME, 1);
                            return cleanStack;
                        }
                    },
                    "EnchantStack vs OtherEnchantStack"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.addEnchant(Enchantment.UNBREAKING, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Enchant vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "Enchant vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.addEnchant(Enchantment.FIRE_PROTECTION, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            meta.addEnchant(Enchantment.FIRE_PROTECTION, 2, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Enchant vs Other"
                }
            ),
            Arrays.asList(
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            ((Repairable) meta).setRepairCost(42);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "Repair vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            ((Repairable) meta).setRepairCost(36);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Repair vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            ((Repairable) meta).setRepairCost(89);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            ItemMeta meta = cleanStack.getItemMeta();
                            ((Repairable) meta).setRepairCost(88);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Repair vs Other"
                }
            )
        );
    }
}
