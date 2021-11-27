public class CharComponentFactory implements AbstractFactory{

    @Override
    public Component Makecomponent() {
        return new CharComponent();
    }
}
