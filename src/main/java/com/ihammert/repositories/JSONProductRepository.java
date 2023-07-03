/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import com.ihammert.core.AbstractProductEntity;

public class JSONProductRepository<T> {

    public AbstractProductEntity getById(int id) {

        try {
            JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();

            if (jSONSweetFriedPastryRepositoty.checkIfExistsById(id)) {
                return jSONSweetFriedPastryRepositoty.getById(id);

            } else {

                JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
                if (jSONDefaultFriedPastryProductsRepository.checkIfExistsById(id)) {
                    return jSONDefaultFriedPastryProductsRepository.getById(id);

                } else {

                    JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
                    if (jSONNaturalJuiceRepository.checkIfExistsById(id)) {
                        return jSONNaturalJuiceRepository.getById(id);
                    } else {
                        JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();

                        if (jSONCannedJuiceRepository.checkIfExistsById(id)) {
                            return jSONCannedJuiceRepository.getById(id);

                        } else {
                            JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
                            if (jSONCandyDessertRepository.checkIfExistsById(id)) {
                                return jSONCandyDessertRepository.getById(id);
                            } else {
                                JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
                                if (jSONChocolateDessertRepository.checkIfExistsById(id)) {
                                    return jSONChocolateDessertRepository.getById(id);
                                } else {
                                    JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
                                    if (jSONOtherProductRepository.checkIfExistsById(id)) {
                                        return jSONOtherProductRepository.getById(id);
                                    }
                                }
                            }
                        }
                    }

                }
            }
            return null; //Não existe o produto com o ID passado

        } catch (Error e) {
            throw new Error("Erro");
        }
    }

    public boolean checkIfExistsByCategoryId(int id) {

        try {
            JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();

            if (jSONSweetFriedPastryRepositoty.checkIfExistsByCategoryId(id)) {
                return true;

            } else {

                JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
                if (jSONDefaultFriedPastryProductsRepository.checkIfExistsByCategoryId(id)) {
                    return true;

                } else {

                    JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
                    if (jSONNaturalJuiceRepository.checkIfExistsByCategoryId(id)) {
                        return true;
                    } else {
                        JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();

                        if (jSONCannedJuiceRepository.checkIfExistsByCategoryId(id)) {
                            return true;

                        } else {
                            JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
                            if (jSONCandyDessertRepository.checkIfExistsByCategoryId(id)) {
                                return true;
                            } else {
                                JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
                                if (jSONChocolateDessertRepository.checkIfExistsByCategoryId(id)) {
                                    return true;
                                } else {
                                    JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
                                    if (jSONOtherProductRepository.checkIfExistsByCategoryId(id)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }

                }
            }
            return false; //Não existe o produto com o ID da categoria

        } catch (Error e) {
            throw new Error("Erro");
        }
    }
    
     public int getIdByName(String name) {

        try {
            JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();

            if (jSONSweetFriedPastryRepositoty.checkIfExistsByName(name)) {
                return jSONSweetFriedPastryRepositoty.getIdByName(name);

            } else {

                JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
                if (jSONDefaultFriedPastryProductsRepository.checkIfExistsByName(name)) {
                    return jSONDefaultFriedPastryProductsRepository.getIdByName(name);

                } else {

                    JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
                    if (jSONNaturalJuiceRepository.checkIfExistsByName(name)) {
                        return jSONNaturalJuiceRepository.getIdByName(name);
                    } else {
                        JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();

                        if (jSONCannedJuiceRepository.checkIfExistsByName(name)) {
                            return jSONCannedJuiceRepository.getIdByName(name);

                        } else {
                            JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
                            if (jSONCandyDessertRepository.checkIfExistsByName(name)) {
                                return jSONCandyDessertRepository.getIdByName(name);
                            } else {
                                JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
                                if (jSONChocolateDessertRepository.checkIfExistsByName(name)) {
                                    return jSONChocolateDessertRepository.getIdByName(name);
                                } else {
                                    JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
                                    if (jSONOtherProductRepository.checkIfExistsByName(name)) {
                                        return jSONOtherProductRepository.getIdByName(name);
                                    }
                                }
                            }
                        }
                    }

                }
            }
            return -1; //Não existe o produto com o ID da categoria

        } catch (Error e) {
            throw new Error("Erro");
        }
    }

}
